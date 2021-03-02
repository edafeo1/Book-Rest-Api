import React, { useState, useEffect } from "react";

import { connect } from "react-redux";
import { deleteBook } from "../../services/index";

import "./../../assets/css/Style.css";
import {
  Card,
  Table,
  Image,
  ButtonGroup,
  Button,
  InputGroup,
  FormControl,
} from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faList,
  faEdit,
  faTrash,
  faStepBackward,
  faFastBackward,
  faStepForward,
  faFastForward,
  faSearch,
  faTimes,
} from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";
import MyToast from "../MyToast";
import BookService from "../Services/Book/bookServices";
import axios from "axios";

const BookList = () => {
  const [books, setBooks] = useState([]);
  const [searchText, setSearchText] = useState("");
  const [totalPages, setTotalPages] = useState("");
  const [totalelements, setTotalElements] = useState("");
  const [currentPage, setCurrentPage] = useState(1);
  const [booksPerPage, setBooksPerPage] = useState(5);
  // const [sortDir, setSortDir] = useState('asc');

  sortData = (sortDir) => {
    setTimeout(() => {
      sortDir === "asc"
        ? setSortDir({ sortDir: "desc" })
        : setSortDir({ sortDir: "asc" });
      BookService.findAllBookByPage(currentPage, booksPerPage);
    }, 500);
  };

  useEffect(() => {
    BookService.findAllBookByPage(currentPage, booksPerPage);
  }, [books]);

  /* Pagination Method Set Up 
    changePage => changes the page to any desired Page Number

    firstPage => changes to first Page 

*/

  return <></>;
};
