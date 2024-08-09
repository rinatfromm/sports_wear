import React from 'react';
import { Product } from '../../model/productTypes';
import { BasketItem } from '../../../Basket/model/basketTypes'
import styles from './ProductItem.module.css';
import useBasketStore from '../../../Basket/model/useBasketStore';
import Button from '../../../../shared/ui/button';

interface ProductItemProps {
    product: Product;
}

const ProductItem: React.FC<ProductItemProps> = ({ product }) => {
    const addItem = useBasketStore((state) => state.addItem);

    const handleAddToBasket = () => {
       
        const basketItem: BasketItem = {
            id: parseInt(product.basket.itemId.id), 
            title: product.basket.itemId.name, 
            price: product.basket.itemId.price,
            image: 'default-image-url', 
            description: 'Default description', 
            quantity: 1
        };

        addItem(basketItem);
    };

    return (
        <li className={styles.card}>
            <h2 className={styles.title}>{product.basket.itemId.name}</h2>
            <p className={styles.price}>Price: ${product.basket.itemId.price}</p>
            <p className={styles.detail}>Name: {product.personalInfo.name}</p>
            <p className={styles.detail}>Last Name: {product.personalInfo.lastName}</p>
            <p className={styles.detail}>Middle Name: {product.personalInfo.middleName}</p>
            <p className={styles.detail}>Phone: {product.personalInfo.phone}</p>
            <p className={styles.detail}>Email: {product.personalInfo.email}</p>
            <p className={styles.detail}>Birth Date: {product.personalInfo.birthDate}</p>
            <Button className={styles.addButton} onClick={handleAddToBasket} title={"Add to Basket"} />
        </li>
    );
};

export default ProductItem;

