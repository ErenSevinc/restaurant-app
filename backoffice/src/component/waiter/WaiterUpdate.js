import React, {Component} from 'react';
import WaiterService from "../../service/WaiterService";
import MediaService from "../../service/MediaService";
import '../../App.css';
import UserContext from "../../UserContext";

class WaiterUpdate extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);
        this.state={
            id : this.props.match.params.id,
            name:'',
            phoneNumber:'',
            mail:'',
            address:'',
            urlToImage:'',
            salary:'',
            image_List:[],
            media:{},
        }
        this.changeNameHandler=this.changeNameHandler.bind(this);
        this.changePhoneHandler=this.changePhoneHandler.bind(this);
        this.changeMailHandler=this.changeMailHandler.bind(this);
        this.changeAddressHandler=this.changeAddressHandler.bind(this);
        this.changeImageHandler=this.changeImageHandler.bind(this);
        this.changeSalaryHandler=this.changeSalaryHandler.bind(this);
        this.selectImage=this.selectImage.bind(this);
    }
    componentDidMount() {
        const{token}=this.context;
        WaiterService.getWaiterById(this.state.id,token).then((res)=>{
            let waiter=res.data
            this.setState({
                name:waiter.name,
                phoneNumber:waiter.phoneNumber,
                mail:waiter.mail,
                address:waiter.address,
                urlToImage:waiter.urlToImage,
                salary:waiter.salary,
                media:waiter.mediaDTO
            });
        });
        MediaService.getImage(token).then(res=>{
            this.setState({image_List:res.data})
        });
    }
    updateWaiter=(e)=>{
        e.preventDefault();
        let waiter={
            id:this.state.id,
            name:this.state.name,
            phoneNumber:this.state.phoneNumber,
            mail:this.state.mail,
            address:this.state.address,
            urlToImage:this.state.urlToImage,
            salary:this.state.salary,
            mediaDTO:this.state.media
        }
        const{token}=this.context;
        WaiterService.updateWaiter(waiter,token).then(res=>{
            this.props.history.push('/waiter')
        });
    }

    cancel(){
        this.props.history.push('/waiter');
    }
    changeNameHandler = (e)=>{
        this.setState({name : e.target.value});
    }
    changePhoneHandler = (e)=>{
        this.setState({phoneNumber : e.target.value});
    }
    changeMailHandler = (e)=>{
        this.setState({mail : e.target.value});
    }
    changeAddressHandler = (e)=>{
        this.setState({address : e.target.value});
    }
    changeImageHandler = (e)=>{
        this.setState({urlToImage : e.target.value});
    }
    changeSalaryHandler = (e)=>{
        this.setState({salary : e.target.value});
    }
    selectImage=(e)=>{
        this.setState({media:e})
        console.log(e);

    }
    onClickCategory=(e)=>{
        this.setState({
            media:e
        });
        console.log(e);
    }
    render() {
        return (
            <div>
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">ADD UPDATE</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label> Waiter Name: </label>
                                    <input placeholder="Waiter Name" name="name" className="form-control"
                                           value={this.state.name} onChange={this.changeNameHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter Phone: </label>
                                    <input placeholder="Waiter Phone" name="phoneNumber" className="form-control"
                                           value={this.state.phoneNumber} onChange={this.changePhoneHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter E-Mail: </label>
                                    <input type="email" placeholder="Waiter E-Mail" name="mail" className="form-control"
                                           value={this.state.mail} onChange={this.changeMailHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter Address: </label>
                                    <input placeholder="Waiter Address" name="address" className="form-control"
                                           value={this.state.address} onChange={this.changeAddressHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter Image: </label>
                                    <input placeholder="Waiter Image" name="urlToImage" className="form-control"
                                           value={this.state.urlToImage} onChange={this.changeImageHandler}/>
                                </div>
                                <div className="form-group">
                                    <label> Waiter Salary: </label>
                                    <input placeholder="Waiter Salary" name="salary" className="form-control"
                                           value={this.state.salary} onChange={this.changeSalaryHandler}/>
                                </div>
                                {/*<div>*/}
                                {/*    {*/}
                                {/*        this.state.image_List.map(*/}
                                {/*            value=>*/}
                                {/*                <div className="form-check">*/}
                                {/*                    <input className="form-check-input" type="radio"*/}
                                {/*                           name="image" id="image"*/}
                                {/*                           onClick={()=>this.selectImage(value)}/>*/}
                                {/*                    <label>{value.name}</label>*/}
                                {/*                </div>*/}


                                {/*        )*/}
                                {/*    }*/}
                                {/*</div>*/}
                                <div className="dropdown show">
                                    <a className="btn btn-secondary btn-block dropdown-toggle" href="#" role="button"
                                       id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                                       aria-expanded="false">
                                    </a>
                                    <div className="dropdown-menu btn-block clm" aria-labelledby="dropdownMenuLink">
                                        {
                                            this.state.image_List.map(
                                                image=>
                                                    <a className="dropdown-item" onClick={this.onClickCategory.bind(this,image)}>{image.name}
                                                        <br/>
                                                        <img src={'data:image/png;base64,' + image.fileContent} width="45" height="45"></img>
                                                    </a>

                                            )
                                        }

                                    </div>
                                </div>
                                <br/>
                                <button className="btn btn-success" onClick={this.updateWaiter}>Save</button>
                                <button className="btn btn-danger" style={{marginLeft: "10px"}}
                                        onClick={this.cancel.bind(this)}>Cancel
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default WaiterUpdate;