import './App.css';
import NavigationBar  from "./components/NavigationBar";
import { Container,Row,Col} from "react-bootstrap";
import Welcome from "./components/Welcome";
import Footer  from "./components/Footer";
import StockList from "./components/StockList";
import AddStock from "./components/AddStock";
import {BrowserRouter as Router,Switch,Route} from "react-router-dom";
function App() {
    const marginTop = {
        marginTop:"20px"
    };
  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
                <Col lg={16}  style={marginTop} >
                    <Switch>
                        <Route path="/" exact component={Welcome}/>
                        <Route path="/list" exact component={StockList}/>
                        <Route path="/add" exact component={AddStock}/>
                    </Switch>
               </Col>
            </Row>

        </Container>
      <Footer/>
    </Router>
  );
}

export default App;
