const gameBoard = document.getElementById('game-board');
const resetBtn = document.getElementById('reset-btn');

const symbols = ['🍎', '🍌', '🍇', '🍓', '🍒', '🍍', '🥝', '🍉'];
let cards = [...symbols, ...symbols];
let flippedCards = [];
let matchedPairs = 0;

function shuffle(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[array[j]]] = [array[j], array[i]];
    }
    return array;
}

function createCard(symbol) {
    const card = document.createElement('div');
    card.classList.add('card');
    card.dataset.symbol = symbol;

    card.innerHTML = `
        <div class="card-face card-front">${symbol}</div>
        <div class="card-face card-back">?</div>
    `;

    card.addEventListener('click', flipCard);
    return card;
}

function flipCard() {
    if (flippedCards.length === 2 || this.classList.contains('flipped') || this.classList.contains('matched')) {
        return;
    }

    this.classList.add('flipped');
    flippedCards.push(this);

    if (flippedCards.length === 2) {
        checkMatch();
    }
}

function checkMatch() {
    const [card1, card2] = flippedCards;
    const isMatch = card1.dataset.symbol === card2.dataset.symbol;

    if (isMatch) {
        card1.classList.add('matched');
        card2.classList.add('matched');
        matchedPairs++;
        flippedCards = [];
        
        if (matchedPairs === symbols.length) {
            setTimeout(() => alert('Congratulations! You won the game!'), 500);
        }
    } else {
        setTimeout(() => {
            card1.classList.remove('flipped');
            card2.classList.remove('flipped');
            flippedCards = [];
        }, 1000);
    }
}

function initGame() {
    gameBoard.innerHTML = '';
    matchedPairs = 0;
    flippedCards = [];
    const shuffledCards = shuffle([...cards]);
    shuffledCards.forEach(symbol => {
        const card = createCard(symbol);
        gameBoard.appendChild(card);
    });
}

resetBtn.addEventListener('click', initGame);

initGame();
