import React, {Component} from  'react';
import {Card, Table, ButtonGroup, Button, InputGroup,FormControl} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList,faTrash,faAd,faFastBackward,faFastForward,faStepBackward,faStepForward} from "@fortawesome/free-solid-svg-icons";
import axios from "axios";
import MyToast from "./MyToast";
import {Link} from "react-router-dom";
export default class StockList extends Component{
    constructor(props) {
        super(props);

        this.state = {
            stocks: [],
            currentPage : 1,
            stocksPerPage : 5
        };
    }
    componentDidMount() {
       this.findAllStocks();
    }
    findAllStocks(){
    axios.get("http://ec2-52-207-138-42.compute-1.amazonaws.com:8080/investments/quotes").then(response => response.data).then((data) =>{
   //  axios.get("http://localhost:8080/investments/quotes").then(response => response.data).then((data) =>{
            console.log(data);
            this.setState({
                stocks:data
            });
        });
    }
    deleteStock = (stickerId) => {
      axios.delete("http://ec2-52-207-138-42.compute-1.amazonaws.com:8080/investments/" + stickerId).
     // axios.delete("http://localhost:8080/investments/" + stickerId).
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
    changePage = event => {
        this.setState({
            [event.target.name] : parseInt(event.target.value)
        });
    };
    firstPage = () => {
        if(this.state.currentPage > 1) {
            this.setState({
                currentPage: 1
            });
        }
    };

    prevPage = () => {
        if(this.state.currentPage > 1) {
            this.setState({
                currentPage: this.state.currentPage - 1
            });
        }
    };

    lastPage = () => {
        let stocksLength = this.state.stocks.length;
        if(this.state.currentPage < Math.ceil(stocksLength / this.state.stocksPerPage)) {
            this.setState({
                currentPage: Math.ceil(stocksLength / this.state.stocksPerPage)
            });
        }
    };

    nextPage = () => {
        if(this.state.currentPage < Math.ceil(this.state.stocks.length / this.state.stocksPerPage)) {
            this.setState({
                currentPage: this.state.currentPage + 1
            });
        }
    };
    render() {
        const {stocks,currentPage,stocksPerPage} = this.state;
        const lastIndex = currentPage * stocksPerPage;
        const firstIndex = lastIndex - stocksPerPage;
        const currentStocks = stocks.slice(firstIndex,lastIndex);
        const totalPages =  stocks.length / stocksPerPage;

        const pageNumCss = {
            width: "45px",
            border: "1px solid #17A2B8",
            color: "#17A2B8",
            textAlign: "center",
            fontWeight: "bold"
        };

        return(
            <div>
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast children={{show:this.state.show, message:"Stock deleted successfully.", type:"danger"}}></MyToast>
                </div>
                <Card className="border border-dark bg-dark text-white">
                    <Card.Header><FontAwesomeIcon icon={faList} /> Stock List </Card.Header>
                    <Card.Body>
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
                                    currentStocks.map((stock,index) => (
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
                    </Card.Body>
                    <Card.Footer>
                        <div style={{"float":"left"}}>
                            Showing page {currentPage} of {totalPages}
                        </div>
                        <div style={{"float":"right"}}>
                            <InputGroup size="sm">
                                <InputGroup.Prepend>
                                    <Button type="button" variant="outline-info" disabled={currentPage === 1 ? true : false } onClick={this.firstPage}> <FontAwesomeIcon icon={faFastBackward} /> First </Button>
                                    <Button type="button" variant="outline-info" disabled={currentPage === 1 ? true : false } onClick={this.prevPage}> <FontAwesomeIcon icon={faStepBackward} /> Prev </Button>
                                </InputGroup.Prepend>
                                <FormControl style= {pageNumCss} className={"bg-dark"} name="currentPage" value={currentPage} onChange={this.changePage}/>
                                <InputGroup.Append>
                                    <Button type="button" variant="outline-info" disabled={currentPage === totalPages ? true : false } onClick={this.nextPage}> <FontAwesomeIcon icon={faStepForward} /> Next </Button>
                                    <Button type="button" variant="outline-info" disabled={currentPage === totalPages ? true : false } onClick={this.lastPage}> <FontAwesomeIcon icon={faFastForward} /> Last </Button>
                                </InputGroup.Append>
                            </InputGroup>

                        </div>
                    </Card.Footer>
                </Card>
            </div>

        );
    }
}
