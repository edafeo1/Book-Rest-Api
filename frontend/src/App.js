import React from 'react';
import './App.css';

import {Container, Row, Col, Jumbotron} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';




export default function App() {

  const heading = "Welcome to Book Store";
  const quote = "Good friends, good books, and a sleepy conscience: this is the ideal life.";
  const footer = "Mark Twain";

  return (
    <Router>

        <Container>
            <Row>
                <Col lg={12} className={"margin-top"}>
                    <Jumbotron className="bg-dark text-white">
                      <h1>Hello world</h1>
                      <p>Heloooo</p>
                    </Jumbotron>
                </Col>
            </Row>
        </Container>
       
    </Router>
  );
}