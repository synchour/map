import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import store from './store';
import { Provider } from "react-redux";
import Map from "./map"
import AutoComplete from "./autocomplete"

ReactDOM.render(
      <AutoComplete />,
      document.getElementById('search')
    );

ReactDOM.render(
      <Provider store={store}>
        <Map />
      </Provider>,
      document.getElementById('gmaps')
    );