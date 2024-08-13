import React from 'react';
import styles from './NavBar.module.css';
import { NavLink } from 'react-router-dom';
import { navigationItems } from '../configHeader';
import { NavItem } from '../../../app/types/NavItem';
import ProductSelect from '../../productSelect';

interface NavBarProps {
  containerClass: string;
  linkClass?: string;
  navItemClass?: string;
  activeLinkClass?: string;
  dropdownToggle?: string;
  arrowBottomClass?: string;
}



const NavBar: React.FC<NavBarProps> = ({
  containerClass,
  dropdownToggle,
  arrowBottomClass,
  linkClass = 'link',
  navItemClass = 'navItem',
  activeLinkClass = 'activeLink'
}) => {
  const handleProductSelect = (productId: number) => {
    console.log(`Selected product ID: ${productId}`);
  };


  return (
    <ul className={styles[containerClass]}>
      <ProductSelect
        onSelect={handleProductSelect}
        dropdownToggle={dropdownToggle}
        arrowBottomClass={arrowBottomClass}
      />
      {navigationItems.map((item: NavItem) => (
        <li key={item.to} className={styles[navItemClass]}>
          <NavLink
            to={item.to}
            className={({ isActive }) => (isActive ? styles[activeLinkClass] : styles[linkClass])}
          >
            {item.text}
          </NavLink>
        </li>
      ))}
    </ul>
  );
};

export default NavBar;
