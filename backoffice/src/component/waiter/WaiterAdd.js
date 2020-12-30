import React, {Component} from 'react';
import WaiterService from "../../service/WaiterService";
import UserContext from "../../UserContext";
import MediaService from "../../service/MediaService";
import '../../App.css';
// import {Formik,Field,Form,ErrorMessage} from "formik";
// import * as Yup from 'yup';

class WaiterAdd extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);
        this.state={
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
        MediaService.getImage().then(res=>{
            this.setState({image_List:res.data})
        });
    }
    saveWaiter =(e)=>{
        e.preventDefault();
        let waiter = {
            name: this.state.name,
            phoneNumber: this.state.phoneNumber,
            mail: this.state.mail,
            address: this.state.address,
            urlToImage: this.state.urlToImage,
            salary: this.state.salary,
            mediaDTO:this.state.media,
        };
        console.log(waiter)
        const{token}=this.context;
        WaiterService.addWaiter(waiter,token).then(res =>{
            this.props.history.push('/waiter')
        })
    }
    cancel=(e)=>{
        e.preventDefault();
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
    showForm(){
        return(
        <form>
            <div className = "form-group">
                <label> Waiter Name: </label>
                <input placeholder="Waiter Name" name="name" className="form-control"
                       value={this.state.name} onChange={this.changeNameHandler}/>
            </div>
            <div className = "form-group">
                <label> Waiter Phone: </label>
                <input placeholder="Waiter Phone" name="phoneNumber" className="form-control"
                       value={this.state.phoneNumber} onChange={this.changePhoneHandler}/>
            </div>
            <div className = "form-group">
                <label> Waiter E-Mail: </label>
                <input type="email" placeholder="Waiter E-Mail" name="mail" className="form-control"
                       value={this.state.mail} onChange={this.changeMailHandler}/>
            </div>
            <div className = "form-group">
                <label> Waiter Address: </label>
                <input placeholder="Waiter Address" name="address" className="form-control"
                       value={this.state.address} onChange={this.changeAddressHandler}/>
            </div>
            <div className = "form-group">
                <label> Waiter Image: </label>
                <input placeholder="Waiter Image" name="urlToImage" className="form-control"
                       value={this.state.urlToImage} onChange={this.changeImageHandler}/>
            </div>
            <div className = "form-group">
                <label> Waiter Salary: </label>
                <input placeholder="Waiter Salary" name="salary" className="form-control"
                       value={this.state.salary} onChange={this.changeSalaryHandler}/>
            </div>

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
            <button className="btn btn-success" onClick={this.saveWaiter}>Save</button>
            <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.cancel.bind(this)}>Cancel</button>
        </form>
        )
    }

    render() {
        return (
            <div>
                <div>
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">ADD WAITER</h3>
                            <div className = "card-body">
                                {this.showForm()}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default WaiterAdd;