import React,{Component} from  'react';
import {Card,Form,Button} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlusSquare,faSave,faUndo} from "@fortawesome/free-solid-svg-icons";
import axios from "axios";
import MyToast from "./MyToast";
export default class AddStock extends  Component{

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.stockChange = this.stockChange.bind(this);
        this.submitStock = this.submitStock.bind(this);
    }
    initialState = {
        stickerSymbol:''
    }
    submitStock = (event) => {
        event.preventDefault();
        const stock = {
            symbol: this.state.stickerSymbol
        };
        axios.post("http://localhost:8080/investments",stock).then( respose  =>{
                if(respose.data != null){
                    this.setState({ "show":true });
                    setTimeout(()=> this.setState({"show":false}),3000)

                }else{
                    this.setState({ "show":false })
                }
        });
        this.setState(this.initialState);
    }
    resetStock = () =>{
        this.setState(() => this.initialState );
    }
    stockChange = (event) => {
        this.setState({
            [event.target.name]:event.target.value
        });

    }

    render() {
        return(
            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast children={{show:this.state.show, message:"Stock saved successfully.", type:"success"}}></MyToast>
                </div>
                <Card className="border border-dark bg-dark text-white">
                    <Card.Header><FontAwesomeIcon icon={faPlusSquare} />  Add Stock </Card.Header>
                    <Form onReset={this.resetStock} onSubmit={this.submitStock}>
                        <Card.Body>
                            <Form.Row>
                                <Form.Group  id="stockFromId" controlId="formGridStock">
                                    <Form.Label>Sticker Symbol</Form.Label>
                                    <Form.Control required
                                                  className={"bg-dark text-white"}
                                                  type="test" name="stickerSymbol"
                                                  placeholder="Enter Sticker Symbol"
                                                  value={this.state.stickerSymbol}
                                                  onChange={this.stockChange}/>
                                </Form.Group>
                            </Form.Row>
                        </Card.Body>
                        <Card.Footer style={{"texAlign":"right"}}>
                            <Button size="sm" variant="success" type="submit"><FontAwesomeIcon icon={faSave} />  Submit</Button> {' '}
                            <Button size="sm" variant="info" type="reset"><FontAwesomeIcon icon={faUndo} />  Reset</Button>
                        </Card.Footer>

                    </Form>
                </Card>
            </div>

        );
    }

}
