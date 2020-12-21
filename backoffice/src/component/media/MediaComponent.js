import React, {useState, useEffect, useContext} from 'react';
import UserContext from "../../UserContext";


function MediaComponent() {
    const [selectedFile,setSelectedFile] = useState();
    const [imageList, setImageList] = useState([]);
    const [loaded,setLoaded]=useState(false);
    const context=useContext(UserContext);


    const onImageOnChange=event=>{
        console.log("event :"+ event);
        if (event.target.files && event.target.files[0]){
            setSelectedFile(event.target.files[0])
        }
    }

    const onFileUpload=()=>{
        if(!selectedFile){
            window.alert("file seçili değil");
            return;
        }

    const data =new FormData();
    data.append('file',selectedFile);
    data.append('imageName',selectedFile.name);

    fetch("http://localhost:8080/file/add",{
        method:'POST',
        mode:'no-cors',
        body:data,
    }).then(res=>res.text())
        .then(result =>console.log("result :"+result))
        .catch(err=>console.warn('error',err));
    }

    useEffect(()=>{
        var requestOptions ={
            method:'GET',
        };
        fetch("http://localhost:8080/file/list",requestOptions)
            .then(res=>res.text())
            .then(result=>setImageList(JSON.parse(result)))
            .catch(err=> console.warn('error',err))
    },[selectedFile]);

    const getFiles =()=>{
        if(!imageList){
            return null;
        }
        let list=[];

        imageList.map(value => {
            list.push(
              <tr>
                  <td>{value.name}</td>
                  <td>
                      <img src={'data:image/png;base64,' + value.fileContent} width="150" style={{margin:10}}/>
                  </td>
              </tr>

            )
        })
        return (
            <table className="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>IMAGE NAME</th>
                    <th>IMAGE</th>
                </tr>
                </thead>
            <tbody>
                {list}
            </tbody>
            </table>
        )
    }

    return (
        <div className="App">
            <header>
                <input type="file" name="file" style={{paddingTop:20}} onChange={(e)=>onImageOnChange(e)}/>
                <button className="btn btn-success" style={{marginTop:20}} onClick={()=>onFileUpload()}>UPLOAD IMAGE</button>
                {getFiles()}
            </header>
        </div>
    );

}

export default MediaComponent;