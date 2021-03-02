import * as bookTypes from "./bookTypes";
import {DeleteBookById} from '../Book/bookAction';
import axios from 'axios';


class BookServices {

    findAllBookByPage = (currentPage, booksPerPage) =>{
        axios.get("URL"+currentPage+booksPerPage)
        .then(response => response.data)
        .then((data) =>{
        setBooks(data.content),
        setTotalPages(data.totalPages),
        setTotalElements(data.totalelements),
        setCurrentPage(data.number)
    })
}

    searchBook = (currentPage, searchText) =>{
        axios.get("URL"+currentPage+searchText)
        .then(response => response.data)
        .then((data) =>{
        setBooks(data.content),
        setTotalPages(data.totalPages),
        setTotalElements(data.totalelements),
        setCurrentPage(data.number)
    })
}
    
   
    deleteById = bookId => {
        DeleteBookById(bookId);
    }

    

}

export default new BookServices();