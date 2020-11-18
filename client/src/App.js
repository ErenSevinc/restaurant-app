import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import Product from "./component/Product";
import Header from "./component/Header";
import Detail from "./component/Detail";
import {useEffect, useState} from "react";
function App() {
    const [content,setContent] = useState();

    useEffect(() => {
        fetch('http://localhost:8080/client/list')
            .then(response => response.json())
            .then(data => {
                //setTotalResults(data.totalResults);
                setContent(data);
            }).catch(e => {
            console.warn("e : ", e);
        });
    }, []);
    if (!content) {
        return null;
    }
    //console.warn("content : ", content);
    return (
        <div className="container">
            <Header/>
            <br/>
            {
                content.map(v => {
                    return(
                        <div>
                            <Detail
                                id={v.id}
                                name={v.name}
                                brand={v.brand}
                                price={v.price}
                                category={v.category}
                            />
                            <br/>
                        </div>
                    )
                })
            }
        </div>
    );
}
export default App;
