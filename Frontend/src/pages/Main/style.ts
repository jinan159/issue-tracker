import styled from 'styled-components';

export const Container = styled.div`
  width: 1280px;
  margin: 0 auto;
`;

export const MenuBar = styled.div`
  ${({ theme }) => theme.mixins.flexBox('row', 'center', 'space-between')};
  margin: 0 0 24px 0;
`;

export const FilterSearchBarContainer = styled.div`
  display: flex;
  align-items: center;
`;

export const Title = styled.h1``;

export const UserInfo = styled.img``;

export const SearchBar = styled.input<{ height: string }>`
  width: 472px;
  height: ${({ height }) => height};
  border: 1px solid ${({ theme }) => theme.colors.greyScale.border};
  border-radius: 0px 11px 11px 0px;
`;

export const TapContainer = styled.div<{
  isMouseOvered: boolean;
  isActive: boolean;
}>`
  ${({ theme }) => theme.mixins.flexBox('row', 'start', 'start')};
  border-radius: 0px 11px 11px 0px;
  background-color: 'red';
  margin: 0 16px 0 0;
`;

export const Menus = styled.div`
  display: flex;
`;
