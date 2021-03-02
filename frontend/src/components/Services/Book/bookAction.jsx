import * as bookTypes from "./bookTypes";
import axios from 'axios';

class BookActions {

    apiRequestSuccess = book => {
        return {
            type: bookTypes.BOOK_SUCCESS,
            payload: book
        };
    };

    apiRequesFailure = error => {
        return {
            type: bookTypes. BOOK_FAILURE,
            payload: error
        }
    }

    SaveBook = book => {
        return dispatch => {
            dispatch({
                type: bookTypes.SAVE_BOOK_REQUEST
            });
            axios.post("URL", book).then(response =>{
                dispatch(this.apiRequestSuccess(response.data));
            }).catch(error => {
                dispatch(this.apiRequesFailure(error));
            });
        };
    };

    GetBookById = Id => {
        return dispatch => {
            dispatch({
                type: bookTypes.FETCH_BOOK_REQUEST,
             });
             axios.get("URL"+Id).then(response =>{
                dispatch(this.apiRequestSuccess(response.data));
            }).catch(error => {
                dispatch(this.apiRequesFailure(error));
            });
        };
    };

    DeleteBookById = Id => {
        return dispatch => {
            dispatch({
                type: bookTypes.DELETE_BOOK_REQUEST,
             });
             axios.delete("URL"+Id).then(response =>{
                dispatch(this.apiRequestSuccess(response.data));
            }).catch(error => {
                dispatch(this.apiRequesFailure(error));
            });
        };
    };

    UpdateBookById = (Id, book) => {
        return dispatch => {
            dispatch({
                type: bookTypes.FETCH_BOOK_REQUEST,
             });
             axios.put("URL" + "/" + Id, book).then(response =>{
                dispatch(this.apiRequestSuccess(response.data));
            }).catch(error => {
                dispatch(this.apiRequesFailure(error));
            });
        };
    };


}

export default new BookActions();