import React, {Component} from 'react';
import InfoService from "../../service/InfoService";
import UserContext from "../../UserContext";

class Info extends Component {
    static contextType=UserContext;
    constructor(props) {
        super(props);
        this.state={
            info:[],

        }
    }
    componentDidMount() {
        const{token}=this.context;
        InfoService.getAppProperties(token).then((res) => {
            this.setState({info: res.data});
        });
    }

    render() {
        return (
            <div className="container">
                <h2 className="text-center">App Properties List</h2>
                <div className="row">
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
                </div>
            </div>
        );
    }
}

export default Info;