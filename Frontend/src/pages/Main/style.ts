import styled from 'styled-components';

export const SpaceBetweenContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

export const FlexContainer = styled.div`
  display: flex;
  align-items: center;
`;

export const Title = styled.h1``;

export const UserInfo = styled.img``;

export const SearchBar = styled.input<{ height: string }>`
  height: ${({ height }) => height};
`;
