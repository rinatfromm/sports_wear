import React from 'react';
import { GrBasket } from 'react-icons/gr';
import styles from './BasketLogo.module.css'
import { NavLink } from 'react-router-dom';
import useBasketStore from '../../../entities/Basket/model/useBasketStore';

const BasketLogo: React.FC = () => {
  const items = useBasketStore((state) => state.items);
  const counter = items.length



  return (
    <NavLink to={'basket'} className={styles.basketLink}>
      <div className={styles.basketLogo}>
        <p className={styles.basketCounter}>{counter}</p>
        <GrBasket className={styles.basketIcon} />
      </div>
    </NavLink>
  );
}

export default BasketLogo;