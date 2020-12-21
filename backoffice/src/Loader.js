import React, {Component} from 'react';
import LoaderGif from './img/loader.gif';
import './App.css';
import UserContext from "./UserContext";
class Loader extends Component {
    static contextType=UserContext;
    state={}
    render() {
        return (
            <div className="loader-container">
                <div className="loader">
                    <img src={LoaderGif}></img>
                </div>
            </div>
        );
    }
}

export default Loader;