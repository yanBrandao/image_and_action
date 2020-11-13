import React, {Component} from 'react';
import './Card.css'
import 'typeface-roboto'
import backgroundCard from './image_action.png'

const cardStyle = {
    backgroundImage: `url(${backgroundCard})`
};

class Card extends Component {
    render() {
        return (
            <div className="Background" onMouseOver="rotateYDIV()">
                <div className="Card" style={cardStyle}>
                    <p className="Phrase">Carpinteiro</p>
                    <p className="Phrase">Faca</p>
                    <p className="Phrase">Calar</p>
                    <p className="Phrase">Carburador</p>
                    <p className="Phrase">Ping-Pong</p>
                    <p className="Phrase">Quadrado</p>
                </div>
            </div>
        );
    }
}

export default Card;