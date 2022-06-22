import styled from 'styled-components';

type ImgSizeProp = {
  size: 'small' | 'medium';
};

const ImgSize = {
  small: '20px',
  medium: '44px',
};

export const Container = styled.div<ImgSizeProp>`
  width: ${({ size }) => ImgSize[size]};
  height: ${({ size }) => ImgSize[size]};
  border-radius: 50%;
  overflow: hidden;
  ${({ theme }) => theme.mixins.flexBox('row', 'center', 'center')}
`;

export const Img = styled.img<ImgSizeProp>`
  width: ${({ size }) => ImgSize[size]};
`;
