import React, {Component} from 'react';
import {Modal} from "react-bootstrap";
import WaiterService from "../service/WaiterService";
import './Component.css';


class Menu extends Component {
    constructor(props) {
        super(props);
        this.state={
            show:false,  // true ise modal gelsin
            waiter_List:[],
        }
    }

    getProductMenu=(e)=>{
        this.props.history.push('/product')
    }
    getWaiter=(e)=>{
        this.setState({show:true});
    }
    componentDidMount() {
        WaiterService.getWaiter().then((res)=>{
            this.setState({waiter_List:res.data})
        })
    }
    selectWaiter(e){

        localStorage.setItem("waiter",e.name);
        this.setState({show:false})
        this.props.history.push('/table')
    }
    showTableState(){
        this.setState({show:false})
        this.props.history.push('/table')
    }

    render() {
        return (
            <div>
                <button className="btn btn-secondary btnOpenOrClose">+</button>
                <div className="menuCard">
                    <a href="/product" className="btn btn-info menuBtn" onClick={this.getProductMenu.bind(this)}>Sipariş</a>
                    <a className="btn btn-info menuBtn" onClick={this.getWaiter.bind(this)}>Masalar</a>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <button className="btn btn-info menuBtn">1</button>
                    <Modal show={this.state.show}>
                        <Modal.Header >
                            GARSON SEÇİNİZ
                        </Modal.Header>
                        <Modal.Body className="mdl">
                            {
                                this.state.waiter_List.map(
                                    wait=>{
                                        return(
                                            <button className="btn btn-warning btn-block" onClick={()=>this.selectWaiter(wait)}>{wait.name}</button>
                                        )
                                    }
                                )
                            }
                        </Modal.Body>
                        <Modal.Footer>
                            <button className="btn btn-info" onClick={()=>this.showTableState()}>Masaları Göster</button>
                        </Modal.Footer>
                    </Modal>
                </div>
            </div>
        );
    }
}

export default Menu;