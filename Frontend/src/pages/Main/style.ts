import styled from 'styled-components';

export const Container = styled.div`
  width: 1280px;
  margin: 0 auto;
`;

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

export const TapContainer = styled.div<{
  isMouseOvered: boolean;
  isActive: boolean;
}>`
  ${({ theme }) => theme.mixins.flexBox('row', 'start', 'start')};
  border-radius: 0px 11px 11px 0px;
  background-color: 'red';
`;
