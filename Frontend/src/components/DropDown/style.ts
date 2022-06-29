import styled from 'styled-components';

export const Container = styled.div<{
  width: string;
  height: string;
}>`
  position: relative;
  background-color: ${({ theme }) => theme.colors.greyScale.inputBackground};
  width: ${({ width }) => width};
  height: ${({ height }) => height};
  border-radius: 11px 0px 0px 11px;
  border: 1px solid ${({ theme }) => theme.colors.greyScale.border};
`;

export const Content = styled.div<{
  width?: string | undefined;
  isStartFromRight?: boolean;
}>`
  display: none;
  position: absolute;
  width: ${({ width }) => width};
  background: transparent;
  box-shadow: 2px 2px 2px 2px
    ${({ theme }) => theme.colors.greyScale.inputBackground};
  right: ${({ isStartFromRight }) => isStartFromRight && '0'};
`;
