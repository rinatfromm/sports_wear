import React from 'react';
import styles from './BasketLogo.module.css'
import { NavLink } from 'react-router-dom';
import useBasketStore from '../../../entities/Basket/model/useBasketStore';
import basket from '../../../shared/icons/basket.svg'

const BasketLogo: React.FC = () => {
  const items = useBasketStore((state) => state.items);
  const counter = items.length



  return (
    <NavLink to={'basket'} className={styles.basketLink}>
      <div className={styles.basketLogo}>
        <p className={styles.basketCounter}>{counter}</p>
        <img src={basket} alt="Logo Basket" />
      </div>
    </NavLink>
  );
}

export default BasketLogo;