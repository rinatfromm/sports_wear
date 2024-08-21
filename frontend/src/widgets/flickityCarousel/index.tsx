import React from 'react';
import Flickity from 'react-flickity-component';
import 'flickity/dist/flickity.min.css';
import { productCards } from '../../shared/utils/productCards';
import ProductItem from '../productCards/productItem';
import styled from 'styled-components';
import './index.css'

const CarouselContainer = styled.div`
    width: 100%;
    margin: 0 auto 96px;
`;

const CarouselCell = styled.div`
width: 33.3%; /* Для отображения трех карточек */
    height: 900px;
    box-sizing: border-box;
    display: flex;
    align-items: center;
    justify-content: center;
`;
const flickityOptions = {
    initialIndex: 0,
    prevNextButtons: false,
    pageDots: true,
    groupCells: 3,
    contain: true,
};

const FlickityCarousel: React.FC = () => {
    return (
        <CarouselContainer >
            <Flickity
                options={flickityOptions}
                disableImagesLoaded={false}
                reloadOnUpdate
                static
            >
                {productCards.map((card, index) => (
                    <CarouselCell key={index} >
                        <ProductItem card={card} />
                    </CarouselCell>
                ))}
            </Flickity>
        </CarouselContainer>
    );
};

export default FlickityCarousel;










