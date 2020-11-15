import React, {Component} from 'react';
import './Card.css'
import 'typeface-roboto'
import backgroundCard from './image_action.png'
import backgroundFront from './image_action_front.png'

const cardStyle = {
    backgroundImage: `url(${backgroundCard})`
};

const cardFront = {
    backgroundImage: `url(${backgroundFront})`,
    backgroundPosition: 'center',
    backgroundRepeat: 'no-repeat',
    backgroundColor: 'white'
};

class Card extends Component {

    constructor(props) {
        super(props);
        this.state = {
            toggle: false,
            personWord: 'Carpinteiro',
            objectWord: 'Faca',
            actionWord: 'Calar',
            mixWord: 'Quadrado',
            hardWord: 'Carburador',
            funWord: 'Ping-Pong'
        };
        this.rotate = this.rotate.bind(this);
        this.card = React.createRef();
    }

    timeout(delay) {
        return new Promise( res => setTimeout(res, delay) );
    }
    rotate() {
        this.card.current.className = 'Card Rotate'
        console.log(this.card.current.className)
        setTimeout(function() { //Start the timer
            this.card.current.className = 'Card FinishRotate' //After 1 second, set render to true
            console.log(this.card.current.className)
            this.setState(function(state) {
                return {
                    toggle: !state.toggle
                };
            });
            if(this.state.toggle) {
                this.setState({
                    personWord: Math.random()
                })
            }
        }.bind(this), 500)

    }

    render() {
        const { toggle, personWord, objectWord, actionWord, mixWord, hardWord, funWord } = this.state;

        return (
            <div className="Background">
                <div className={'Card'}
                     ref={this.card}
                     onClick={this.rotate} style={toggle ? cardStyle : cardFront}>
                    <p className="Word">{toggle ? personWord: ''}</p>
                    <p className="Word">{toggle ? objectWord : '' }</p>
                    <p className="Word">{toggle ? actionWord : '' }</p>
                    <p className="Word">{toggle ? hardWord : '' }</p>
                    <p className="Word">{toggle ? funWord : '' }</p>
                    <p className="Word">{toggle ? mixWord : '' }</p>
                </div>

            </div>
        );
    }
}

export default Card;