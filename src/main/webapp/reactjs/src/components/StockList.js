import React, {Component} from  'react';
import {Card, Table, ButtonGroup, Button, Nav} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList,faEdit,faTrash,faAd} from "@fortawesome/free-solid-svg-icons";
import axios from "axios";
import MyToast from "./MyToast";
import {Link} from "react-router-dom";
export default class StockList extends Component{
    constructor(props) {
        super(props);

        this.state = {
            stocks: []
        };
    }
    componentDidMount() {
       this.findAllStocks();
    }
    findAllStocks(){
        axios.get("http://localhost:8080/investments/quotes").then(response => response.data).then((data) =>{
            console.log(data);
            this.setState({
                stocks:data
            });
        });
    }
    deleteStock = (stickerId) => {
        axios.delete("http://localhost:8080/investments/" + stickerId).
        then(response =>{
            if(response.data != null){
                  this.setState({ "show":true });
                  setTimeout(()=> this.setState({"show":false}),3000)
                  this.setState({
                    stocks: this.state.stocks.filter(stock => stock.symbol !== stickerId)
                })
            }else{
               this.setState({ "show":false })
            }
        });
    };
    render() {
        const {stocks} = this.state;
        return(
            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast children={{show:this.state.show, message:"Stock deleted successfully.", type:"danger"}}></MyToast>
                </div>
                <Card className="border border-dark bg-dark text-white">
                    <Card.Header><FontAwesomeIcon icon={faList} /> Stock List </Card.Header>
                    <Table bordered hover striped variant="dark">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Symbol</th>
                            <th>Description</th>
                            <th>BidPrice</th>
                            <th>BidSize</th>
                            <th>OpenPrice</th>
                            <th>HighPrice</th>
                            <th>ClosePrice</th>
                            <th>52WkHigh</th>
                            <th>52WkLow</th>
                            <th>NetChange</th>
                            <th>Div Amount</th>
                            <th>TotalVolume</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            stocks.length === 0 ?
                                <tr align="center">
                                    <td colSpan={16}> Stocks are not available</td>
                                </tr>
                                :
                                this.state.stocks.map((stock,index) => (
                                    <tr key={index}>
                                        <td> {index} </td>
                                        <td> {stock.symbol} </td>
                                        <td> {stock.description} </td>
                                        <td> {stock.bidPrice} </td>
                                        <td> {stock.bidSize} </td>
                                        <td> {stock.openPrice} </td>
                                        <td> {stock.highPrice} </td>
                                        <td> {stock.closePrice} </td>
                                        <td> {stock.high52Week} </td>
                                        <td> {stock.low52Week} </td>
                                        <td> {stock.netChange} </td>
                                        <td> {stock.divAmount} </td>
                                        <td> {stock.totalVolume} </td>
                                        <td>
                                            <ButtonGroup>
                                                <Link to={"add"} className="btn btn-sm btn-outline-primary"><FontAwesomeIcon icon={faAd} /> Add Stock </Link>{' '}
                                                <Button size="sm" variant="outline-danger" onClick={this.deleteStock.bind(this,stock.symbol)}> <FontAwesomeIcon icon={faTrash} /> </Button>
                                            </ButtonGroup>
                                        </td>
                                    </tr>

                                ))

                        }
                        </tbody>
                    </Table>
                </Card>
            </div>

        );
    }
}
