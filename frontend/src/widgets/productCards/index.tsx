import React, { useState } from 'react';
import boxer from '../../shared/ assets/  images/box.svg';
import styles from './ProductCards.module.css'; 

interface Card {
  img: string;
  title: string;
  price: number;
  color: string[];
  sizes: string[];
}

const cards: Card[] = [
  {
    img: boxer,
    title: 'Sample Card Title',
    price: 19.99,
    color: ['red', 'blue', 'green'],
    sizes: ['S', 'M', 'L']
  },
  {
    img: boxer,
    title: 'Sample Card Title 1',
    price: 19.99,
    color: ['red', 'blue', 'green'],
    sizes: ['S', 'M', 'L']
  },
  {
    img: boxer,
    title: 'Sample Card Title 2',
    price: 29.99,
    color: ['yellow', 'purple'],
    sizes: ['M', 'L', 'XL']
  }
];

interface ProductCardProps {
  card: Card;
}

const ProductCard: React.FC<ProductCardProps> = ({ card }) => {

  const [selectedColor, setSelectedColor] = useState<string | null>(null);
  const [selectedSize, setSelectedSize] = useState<string | null>('M');

  return (

    <div className={styles.card}>
      <img src={card.img} alt={card.title} className={styles.cardImg} />
      <h2 className={styles.cardTitle}>{card.title}</h2>
      <p className={styles.cardPrice}>Price: ${card.price}</p>
      <div className={styles.cardColors}>
        <label>Colors:</label>
        <div className={styles.btnsColor}>
          {card.color.map((color, colorIndex) => (
            <button
              key={colorIndex}
              className={`${styles.colorButton} ${selectedColor === color ? styles.active : ''}`}
              style={{ backgroundColor: color }}
              onClick={() => setSelectedColor(color)}
            >
            </button>
          ))}
        </div>
      </div>
      <div className={styles.cardSizes}>
        <label>Sizes:</label>
        <div className={styles.btnsSizes}>
          {card.sizes.map((size, sizeIndex) => (
            <button
              key={sizeIndex}
              className={`${styles.sizeButton} ${selectedSize === size ? styles.active : ''}`}
              onClick={() => setSelectedSize(size)}
            >
              {size}
            </button>
          ))}
        </div>
      </div>
    </div>
  );
};
function ProductCards() {
  return (
    <>
      <div className={styles.classContainer}>
        {cards.map((card, index) => (
          <ProductCard key={index} card={card} />
        ))}
      </div>
    </>
  );
}

export default ProductCards;





