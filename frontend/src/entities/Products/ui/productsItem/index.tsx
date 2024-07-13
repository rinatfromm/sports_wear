import React from 'react';
import { Product } from '../../model/productTypes';
import styles from './ProductItem.module.css'; // импорт стилей
import useBasketStore from '../../../Basket/model/useBasketStore';
import Button from '../../../../shared/ui/button';

interface ProductItemProps {
    product: Product;
}

const ProductItem: React.FC<ProductItemProps> = ({ product }) => {
    const addItem = useBasketStore((state) => state.addItem);


    const handleAddToBasket = () => {
        addItem({
            ...product,
            quantity: 1,
        });
    };




    return (
        <li className={styles.card}>
            <h2 className={styles.title}>{product.id}</h2>
            <p className={styles.description}>{product.description}</p>
            <p className={styles.price}>Price: ${product.basket.itemId.price}</p>
            <img src={product.image} alt={product.title} className={styles.image} />
            <Button className={styles.addButton} onClick={handleAddToBasket} title={"Add to Basket"} />
        </li>
    );
};

export default ProductItem;
