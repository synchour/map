import React from 'react';
import Select from 'react-select';
import fetch from 'isomorphic-fetch';
import store from './store';

const AutoComplete = React.createClass({
	propTypes: {
		label: React.PropTypes.string,
	},
	getInitialState () {
		return {};
	},
	onChange (value) {
		if (!value) {
			this.setState({
				value: {},
			});
			return;
		}

		fetch(`http://localhost:8000/sfmovie/titleLocations?title=${value.title}`)
		.then((response) => response.json())
		.then((json) => {
			store.dispatch({
            type: "MOVIE_SELECTED",
            payload: json
        	})
		});
		
		this.setState({
			value: value,
		});
	},
	getUsers (input) {
		if (!input) {
			return Promise.resolve({ options: [] });
		}

		return fetch(`http://localhost:8000/sfmovie/titles?searchTerm=${input}`)
		.then((response) => response.json())
		.then((json) => {
			return { options: json.movieLocations };
		});
	},
	render () {
		return (
			<Select.Async multi={false} value={this.state.value} onChange={this.onChange} valueKey="title" labelKey="title" loadOptions={this.getUsers} backspaceRemoves={true} />
		);
	}
});

module.exports = AutoComplete;