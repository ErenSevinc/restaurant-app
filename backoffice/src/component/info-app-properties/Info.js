import React, {Component} from 'react';
import InfoService from "../../service/InfoService";

class Info extends Component {
    constructor(props) {
        super(props);
        this.state={
            info:[],

        }
    }
    componentDidMount() {
        InfoService.getAppProperties().then((res) => {
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