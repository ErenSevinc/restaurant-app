import React, {Component} from 'react';
import axios from "axios";
import {Modal} from "react-bootstrap";
import TableCategoryService from "../service/TableCategoryService";
import Table from "react-bootstrap/Table";
import './Component.css'
import CategotyNew from "./CategotyNew";
import CustomerService from "../service/CustomerService";
import WaiterService from "../service/WaiterService";

class TableList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            table_category_list: [],
            tableList: [],
            amount:'',
            tableCategory:'',
            items:[],

            show:false,  // true ise modal gelsin
            waiter_List:[],


        }
        this.getAllTables = this.getAllTables.bind(this)
        this.goToSale=this.goToSale.bind(this)

    }

    componentDidMount() {
        TableCategoryService.getTableCategory().then((res) => {
            this.setState({table_category_list: res.data})
        });
        const{token}=this.context;
        WaiterService.getWaiter().then((res)=>{
            this.setState({waiter_List:res.data})
        });
    }

    getAllTables = (e) => {
         TableCategoryService.getByTableCategoryID(e.id).then((res)=>{
             this.setState({amount: res.data.amount})
         })
        this.setState({tableCategory:e.name})

        this.state.items=[];
        const tableData=[];
        let totalAmount=0;
        let totalPrice=0;
        let orders=CategotyNew.getOrderFromStorage();
        const tableCategoryName=e.name;
         for(let i=0;i<orders.length;i++){
             if(orders[i][0].tableName.indexOf(tableCategoryName)>-1){
                 for(let j=0;j<orders[i].length;j++){
                     totalAmount += orders[i][j].piece;
                     totalPrice += orders[i][j].productPrice;

                 }
                 tableData.push(orders[i][0].tableName + ' ' + totalAmount);
                 totalAmount=0;
             }
         }
         let tableDataString=JSON.stringify(tableData);
         console.log(tableDataString);


        for (let i=1; i <= this.state.amount; i++){

            let fullTable = `Masa ${i}!`;

            if(tableDataString.indexOf(fullTable)>-1){
                let startIndex=tableDataString.indexOf(fullTable)+fullTable.length;  //başlangıç noktasınını masa i,
                let fullTableProductAmount = tableDataString.substr(startIndex,2);  //masanın sipariş adetini
                console.log(fullTableProductAmount);
                this.state.items.push(
                    <button className="btn btn-info but"
                            onClick={()=> this.goToSale(i)}> <h5>Masa {i}</h5> {fullTableProductAmount} adet ürün</button>
                )
            }
            else{
                this.state.items.push(
                    <button className="btn btn-outline-info but"
                            onClick={()=> this.goToSale(i)}>Masa {i}</button>
                )
            }

        }
        return this.state.items;
    }


    selectWaiter(e){
        localStorage.setItem("waiter",e.name);
        this.setState({show:false});
        this.props.history.push('/products');
    }
    showState(){
        this.setState({show:false})
    }
    showTableState(){
        this.setState({show:false})
        this.props.history.push('/products')
    }
    goToSale(no){
        this.setState({show:true})
        //localStorage.removeItem("orders")
        sessionStorage.setItem("tbl", this.state.tableCategory + ' Masa '+no + '!');
    }

    render() {

        return (
            <div>
               <div className="container-fluid">
                   <div className="row">
                       <div className="col-xl-3">
                           <Modal show={this.state.show}>
                               <Modal.Header>
                                   GARSON SEÇİNİZ
                               </Modal.Header>
                               <Modal.Body className="mdl">
                                   {
                                       this.state.waiter_List.map(
                                           wait=>{
                                               return(
                                                   <button className="btn btn-warning" onClick={()=>this.selectWaiter(wait)} style={{margin:"10px"}}>{wait.name}
                                                       <img src={'data:image/png;base64,' + wait.mediaDTO.fileContent} width="50" height="75"></img>
                                                   </button>
                                               )
                                           }
                                       )
                                   }
                               </Modal.Body>
                               <Modal.Footer>
                                   <button className="btn btn-info" onClick={() =>this.showState()}>Masaları Göster</button>
                                   <button className="btn btn-info" onClick={() => this.showTableState()}>Ayakta Sipariş</button>
                               </Modal.Footer>
                           </Modal>
                           <div className="card">
                               <div className="card-header">MASA KATEGORİ</div>
                               <div className="card-body">
                                   {
                                       this.state.table_category_list.map(
                                           catList =>
                                               <button className="btn btn-info btn-block"
                                                       onClick={() => this.getAllTables(catList)}> {catList.name}
                                                       <br/>
                                                   <img src={'data:image/png;base64,' + catList.mediaDTO.fileContent}
                                                        width="50" style={{margin: 10}}/>
                                               </button>

                                       )
                                   }
                               </div>
                           </div>
                       </div>
                       <div className="col-xl-9">
                           <div className="card crd">
                               <div className="card-header">MASALAR</div>
                               <div className="row clm">
                                   <div className="card-body">
                                       {this.state.items}
                                   </div>
                               </div>
                           </div>
                       </div>
                   </div>
               </div>
            </div>
        );
    }
}

export default TableList;