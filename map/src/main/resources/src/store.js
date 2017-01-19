import { applyMiddleware, createStore } from "redux";
import logger from "redux-logger"
import thunk from "redux-thunk";

const middleWare = applyMiddleware(thunk, logger());

const reducer = function(state, action) {
    switch (action.type) {
        case "MOVIE_SELECTED":
            return action.payload;
        default:
            return state;
    }
}

export default createStore(reducer, {}, middleWare);