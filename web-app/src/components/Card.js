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
            toggle: false
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
        }.bind(this), 500)

    }

    render() {
        const { toggle } = this.state;

        return (
            <div className="Background">
                <div className={'Card'}
                     ref={this.card}
                     onClick={this.rotate} style={toggle ? cardStyle : cardFront}>
                    <p className="Phrase">{toggle ? 'Carpinteiro' : ''}</p>
                    <p className="Phrase">{toggle ? 'Faca' : '' }</p>
                    <p className="Phrase">{toggle ? 'Calar' : '' }</p>
                    <p className="Phrase">{toggle ? 'Carburador' : '' }</p>
                    <p className="Phrase">{toggle ? 'Ping-Pong' : '' }</p>
                    <p className="Phrase">{toggle ? 'Quadrado' : '' }</p>
                </div>

            </div>
        );
    }
}

export default Card;