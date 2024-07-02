import React, { useEffect } from 'react';
import useProductStore from '../../model/useProductStore';
import ProductItem from '../productsItem';
import styles from './ProductList.module.css'

const ProductList: React.FC = () => {
    const { productsAll, fetchProducts } = useProductStore(state => ({
        productsAll: state.productsAll,
        fetchProducts: state.fetchProducts
    }));

    useEffect(() => {
        fetchProducts();
    }, [fetchProducts]);

    return (
        <div>
            <h2>Products List</h2>
            <ul className={styles.conteiner}>
                {productsAll.map(product => (
                    <ProductItem key={product.id} product={product} />
                ))}
            </ul>
        </div>
    );
};

export default ProductList;
