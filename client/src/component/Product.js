import React, {useEffect, useState} from 'react';
import Service from "../service/Service";
import Detail from "./Detail";

function Product() {
    // const[message,setMessage] = useState("Hello from state"); //{message}
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

            <br/>
            {
                content.map(v => {
                    return(
                        <div>
                            <Detail
                                id={v.name}
                                title={v.brand}
                                description={v.price}
                                urlToImage={v.category}
                            />
                            <br/>
                        </div>
                    )
                })
            }
        </div>
    );
}


export default Product;