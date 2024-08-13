import React, { useState } from 'react';
import { products } from './products';
import styles from './ProductSelect.module.css';
// import arrow_bottom from '../../shared/icons/arrow-bottom.svg'

interface ProductSelectProps {
    onSelect: (productId: number) => void;
    dropdownToggle?: string;
    arrowBottomClass?: string;
}

const ProductSelect: React.FC<ProductSelectProps> = ({ onSelect, dropdownToggle = 'dropdownToggle', arrowBottomClass = 'arrowBottomClass' }) => {
    const [isOpen, setIsOpen] = useState(false);

    const toggleDropdown = () => setIsOpen(!isOpen);

    return (
        <div className={styles.productSelect}>
            <button onClick={toggleDropdown} className={styles[dropdownToggle]}>
                Products
                <div className={styles[arrowBottomClass]}></div>
            </button>
            {isOpen && (
                <ul className={styles.dropdownMenu}>
                    {products.map(product => (
                        <li key={product.id} onClick={() => onSelect(product.id)} className={styles.menuItem}>
                            <a href={product.to}>{product.name}</a>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default ProductSelect;

