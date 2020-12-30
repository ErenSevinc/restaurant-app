import React, {Component} from 'react';
import InfoService from "../../service/InfoService";
import UserContext from "../../UserContext";
import ReactToExcel from 'react-html-table-to-excel';

class Info extends Component {
    static contextType = UserContext;

    constructor(props) {
        super(props);
        this.state = {
            info: [],
            beans: [],
            beans_index: [],
            flag_prp:true,
            flag_bean:false,
        }
    }

    componentDidMount() {
        const {token} = this.context;
        InfoService.getAppProperties(token).then((res) => {
            this.setState({info: res.data});
        });
        InfoService.getAllBeans(token).then((res) => {
            this.setState({
                beans: res.data
            })
        })
    }

    showAppProperties=()=> {
        if (this.state.info == null) {
            return;
        }
        return (<div className="row">
            <table className="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Key</th>
                    <th>Value</th>
                </tr>
                </thead>
                <tbody>
                {
                    this.state.info.map(
                        i =>
                            <tr>
                                <td>{i.key}</td>
                                <td>{i.value}</td>
                            </tr>
                    )
                }
                </tbody>
            </table>
        </div>);

    }

    showBeanList=()=> {
        if (this.state.beans == null) {
            return;
        }
        return (
            <div className="row">
                <table className="table table-striped table-bordered" id="table-to-xls">
                    <thead>
                    <tr>
                        <th>Index</th>
                        <th>
                            <ReactToExcel
                            className="btn btn-warning"
                            table="table-to-xls"
                            filename="BeanListExcelFile"
                            sheet="sheet 1"
                            buttonText="Bean List"

                            /></th>


                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.beans.map(
                            (v, index) =>
                                <tr>
                                    <td>{index + 1}</td>
                                    <td>{v}</td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>);
    }
    render() {
        return (
            <div>
                <div>
                    <h2 className="text-center">App Properties List</h2>
                </div>
                {this.showAppProperties()}
                <div >
                    <h2 className="text-center">Bean List</h2>
                </div>
                {this.showBeanList()}

            </div>
        );
    }
}

export default Info;