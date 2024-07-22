import React from 'react';
import styles from './NavBar.module.css';
import { NavLink } from 'react-router-dom';
import { navigationItems } from '../configHeader';
import { NavItem } from '../../../app/types/NavItem';
import LogoHeader from '../logo';
import ProductSelect from '../../productSelect';


const NavBar: React.FC = () => {
  const handleProductSelect = (productId: number) => {
    console.log(`Selected product ID: ${productId}`);
  };




  return (
    <ul className={styles.navBar}>
      <LogoHeader />
      <ProductSelect onSelect={handleProductSelect} />
      {navigationItems.map((item: NavItem) => (
        <li key={item.to} className={styles.navItem}>
          <NavLink
            to={item.to}
            className={({ isActive }) => isActive ? styles.activeLink : styles.link}
          >
            {item.text}
          </NavLink>
        </li>
      ))}
    </ul>
  );
};

export default NavBar;
