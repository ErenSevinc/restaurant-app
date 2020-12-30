import React, {Component} from 'react';
import Loader from "../../Loader";
import UserContext from "../../UserContext";
import CustomerService from "../../service/CustomerService";
import ReactToExcel from 'react-html-table-to-excel';

class CustomerList extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);
        this.state={
            elementsCount:0,
            page:0,
            size:5,
            customerList:[],
            customerPaginationList:[],

            loaded:false,
        }
        this.add = this.add.bind(this)
        this.updatedCustomer = this.updatedCustomer.bind(this);
        this.deletedCustomer = this.deletedCustomer.bind(this);
        this.detailCustomer = this.detailCustomer.bind(this);
        this.buttonImpl = this.buttonImpl.bind(this);
    }
    add() {
        this.props.history.push('/customer-add');
    }

    updatedCustomer(id) {
        this.props.history.push(`/customer-update/${id}`);
    }

    deletedCustomer(id) {
        const{token}=this.context;
        this.setState({loaded:!this.state.loaded});
        CustomerService.deleteCustomer(token,id).then(res => {
            this.props.history.push('/customer-add');
            if (res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        });
    }

    detailCustomer(id) {
        this.props.history.push(`/customer-detail/${id}`);
    }


    componentDidMount() {
        const{token}=this.context;
        this.setState({loaded:!this.state.loaded});
        // CustomerService.getCustomers(token).then((res)=>{
        //     this.setState({
        //         customerList:res.data,
        //     });
        //     if (res.status == '200'){
        //         this.setState({loaded:!this.state.loaded});
        //     }
        // });
        CustomerService.getPaginatonCustmoers(token,this.state.page,this.state.size).then((res)=>{
            this.setState({
                customerList:res.data.customerDTOList,
                elementsCount:res.data.totalElements,
                size:res.data.size
            });
            if (res.status == '200'){
                this.setState({loaded:!this.state.loaded});
            }
        })
    }
    buttonImpl=(e)=>{
        const{token}=this.context;
        CustomerService.getPaginatonCustmoers(token, e,this.state.size).then((res)=>{
            this.setState({
                customerPaginationList: res.data.customerDTOList,
                elementsCount: res.data.totalElements,
                customerList:this.state.customerPaginationList
            });
        });
    }


    render() {
        const btn=[];
        for (let i=0;i<Math.ceil(this.state.elementsCount/this.state.size);i++){
            btn.push(
                <button className="btn btn-outline-success" onClick={()=>this.buttonImpl(i)}>{i+1}</button>
            )
        }
        return (
            <div>
                <h2 className="text-center">Customer List</h2>

                <div>
                    <button className="btn btn-success" onClick={this.add} style={{marginRight:"50px"}}>Add Customer</button>
                    <label style={{marginRight:"25px"}}>Toplam müşteri sayısı:<p style={{fontSize:"20px",fontStyle:"bold"}}>{this.state.elementsCount}</p></label>
                    {btn}
                </div>
                <div>

                    <table className="table table-striped table-bordered" id="table-to-xls">
                        <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Customer Name </th>
                            <th>Customer PhoneNumber</th>
                            <th>Customer Address</th>
                            <th>Customer Image</th>
                            <th>
                                <ReactToExcel
                                className="btn btn-warning"
                                table="table-to-xls"
                                filename="excelFile"
                                sheet="sheet 1"
                                buttonText="Report Customer"

                                />
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.customerList.map(
                                customer =>
                                    <tr key={customer.id}>
                                        <td>{customer.id}</td>
                                        <td>{customer.firstName} {customer.lastName}</td>
                                        <td>{customer.phoneNumber}</td>
                                        <td>{customer.address}</td>
                                        <td><img src={'data:image/png;base64,' + customer.mediaDTO.fileContent} width="150" height="150"/></td>
                                        <td>
                                            <button onClick={() => this.updatedCustomer(customer.id)}
                                                    className="btn btn-info" style={{margin: "5px"}}>Update
                                            </button>
                                            <button onClick={() => this.deletedCustomer(customer.id)}
                                                    className="btn btn-danger">Delete
                                            </button>
                                            <button onClick={() => this.detailCustomer(customer.id)}
                                                    className="btn btn-warning" style={{margin: "5px"}}>Detail
                                            </button>
                                        </td>
                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                    <div style={{marginLeft:"450px"}}>
                        {btn}
                    </div>
                </div>
                {
                    this.state.loaded ?(
                        <Loader/>
                    ):null
                }
            </div>
        );
    }
}

export default CustomerList;