import React from 'react';
import './App.css';

import {Container, Row, Col, Jumbotron} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Welcome from './components/Welcome';
import Footer from './components/Footer';
import Navigation from './components/Navigation';




export default function App() {

  const heading = "Welcome to Book Store";
  const quote = "Good friends, good books, and a sleepy conscience: this is the ideal life.";
  const footer = "Mark Twain";

  return (
    <Router>
      <Navigation/>
        <Container>
            <Row>
                <Col lg={12} className={"margin-top"}>
                    <Switch>
                        <Route path="/" exact component={() => <Welcome heading={heading} quote={quote} footer={footer}/>}/>
                        
                    </Switch>
                </Col>
            </Row>
        </Container>
        <Footer/>
        
       
    </Router>
  );
}