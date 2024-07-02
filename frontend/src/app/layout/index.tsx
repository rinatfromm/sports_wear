import { FC, Fragment, } from "react";
import styles from './Layout.module.css'
import Footer from "../../widgets/footer";
import Header from "../../widgets/header";
import { Outlet } from "react-router-dom";


const Layout: FC = () => {
    return (
        <Fragment>
            <div className="App">
                <Header />
                <main className={styles.mainContainer}>
                    <Outlet />
                </main>
                <Footer />
            </div >
        </Fragment>
    );
};

export default Layout;