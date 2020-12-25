import React, {Component} from 'react';
import {Modal} from "react-bootstrap";
import WaiterService from "../service/WaiterService";
import './Component.css';
import UserContext from "../UserContext";
import CustomerService from "../service/CustomerService";


class Menu extends Component {
    static contextType = UserContext;

    constructor(props) {
        super(props);
        this.state = {
            showCustomer: false,
            cstm_flag: 0,

            elementsCount: 0,
            page: 0,
            size: 5,
            customerList: [],
            customerPaginationList: [],

        }
        this.add = this.add.bind(this);
        this.buttonImpl = this.buttonImpl.bind(this);
    }

    getProductMenu = (e) => {
        this.props.history.push('/products')
    }
    goTable=(e)=>{
        if(this.state.cstm_flag == 1){
            this.props.history.push('/table');
        }
    }
    add(){
        this.props.history.push('/customer-add');
    }

    componentDidMount() {
        CustomerService.getPaginatonCustmoers(this.state.page, this.state.size).then((res) => {
            this.setState({
                customerList: res.data.customerDTOList,
                elementsCount: res.data.totalElements,
                size: res.data.size
            });
        });
    }

    saveLocalStorageCustomer(cstmr) {
        this.setState({cstm_flag:1})
        localStorage.setItem("customer_id",cstmr.id);
        localStorage.setItem("customer_name", cstmr.firstName + ' ' + cstmr.lastName);
        localStorage.setItem("customer_number", cstmr.phoneNumber);
        localStorage.setItem("customer_address", cstmr.address);
    }


    showTableState() {
        if(this.state.cstm_flag === 1){
            this.setState({showCustomer: false})
            sessionStorage.setItem("tbl", this.state.tableCategory + ' Masa 0 !');
            this.props.history.push('/products')
        }
    }

    showTable=(e)=> {
        localStorage.removeItem("customer_id");
        localStorage.removeItem("customer_name");
        localStorage.removeItem("customer_number");
        localStorage.removeItem("customer_address");
        this.setState({showCustomer: !this.state.showCustomer})
    }
    // createBtn(){
    //
    // }

    buttonImpl = (e) => {
        CustomerService.getPaginatonCustmoers(e, this.state.size).then((res) => {
            this.setState({
                customerPaginationList: res.data.customerDTOList,
                elementsCount: res.data.totalElements,
                customerList: this.state.customerPaginationList
            });
        });
    }

    render() {
        const btn = [];
        for (let i = 0; i < Math.ceil(this.state.elementsCount / this.state.size); i++) {
            btn.push(
                <button className="btn btn-outline-link" onClick={() => this.buttonImpl(i)}>{i + 1}</button>
            )
        }
        return (
            <div>
                <button className="btn btn-secondary btnOpenOrClose">+</button>
                <div className="menuCard">
                    <a href="/products" className="btn btn-info menuBtn"
                       onClick={this.getProductMenu.bind(this)}>Sipariş</a>
                    <a className="btn btn-info menuBtn" onClick={this.showTable.bind(this)}>Masalar</a>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <Modal show={this.state.showCustomer}>
                        <Modal.Header>
                            <Modal.Title>
                                <label>{localStorage.getItem("customer_name")}</label>
                                <br/>
                                {btn}
                            </Modal.Title>
                            <button className="btn btn-outline-success"onClick={this.add}>MÜŞTERİ EKLE</button>
                        </Modal.Header>
                        <Modal.Body className="mdl">{
                            this.state.customerList.map(
                                customer =>
                                    <button className="btn btn-secondary btn-block"
                                            onClick={() => this.saveLocalStorageCustomer(customer)}>{customer.firstName} {customer.lastName}</button>
                            )
                        }
                        </Modal.Body>
                        <Modal.Footer>
                            <button className="btn btn-danger" onClick={() => this.showTable()}>Menüye Dön</button>
                            <button className="btn btn-info" onClick={() => this.goTable()}>Masaları Göster</button>
                            <button className="btn btn-info" onClick={() => this.showTableState()}>Ayakta Sipariş</button>
                        </Modal.Footer>
                    </Modal>

                </div>
            </div>
        );
    }
}

export default Menu;