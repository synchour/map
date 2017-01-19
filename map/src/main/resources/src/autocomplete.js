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
			this.updateOptions();
			this.setState({
				value: {},
			});
			return;
		}

		fetch(`/sfmovie/titleLocations?title=${value.title}`)
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
	updateOptions (input) {
		if (!input) {
			console.log("options cleared")
			return Promise.resolve({ options: [] });
		}

		return fetch(`/sfmovie/titles?searchTerm=${input}`)
		.then((response) => response.json())
		.then((json) => {
			console.log("options updated")
			return { options: json.movieLocations };
		});
	},
	render () {
		return (
			<Select.Async multi={false} value={this.state.value} onChange={this.onChange} valueKey="title" labelKey="title" loadOptions={this.updateOptions} backspaceRemoves={true} />
		);
	}
});

module.exports = AutoComplete;