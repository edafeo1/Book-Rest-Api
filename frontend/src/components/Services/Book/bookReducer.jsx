import * as bookTypes from '../Book/bookTypes';

const initialState = {
    book: '', error: ''
};

const reducer = (state = initialState, action) => {
    switch(action.type) {
        case bookTypes.SAVE_BOOK_REQUEST:
        case bookTypes.FETCH_BOOK_REQUEST:
        case bookTypes.UPDATE_BOOK_REQUEST:
        case bookTypes.DELETE_BOOK_REQUEST:
       // case bookTypes.FETCH_LANGUAGES_REQUEST:
       // case bookTypes.FETCH_GENRES_REQUEST:   
         return{
            ...state
        };

        case bookTypes.BOOK_SUCCESS:
            return{
                book: action.payload,
                error: ''
            };

        case bookTypes.BOOK_FAILURE:
            return {
                book: '',
                error: action.payload
            };

        default: return state;
    }
}