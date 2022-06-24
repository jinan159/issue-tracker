import styled from 'styled-components';

export const StyledTap = styled.button<{
  isMouseOvered: boolean;
  isActive: boolean;
  borderDirection: 'left' | 'right';
}>`
  width: 160px;
  height: 40px;
  ${({ theme }) => theme.mixins.flexBox('row', 'center', 'center')};
  background-color: ${({ theme, isMouseOvered, isActive }) =>
    (isActive && theme.colors.greyScale.line) ||
    (isMouseOvered && theme.colors.greyScale.inputBackground) ||
    theme.colors.greyScale.background};
  border-radius: ${({ borderDirection }) =>
    (borderDirection === 'left' && '11px 0px 0px 11px') ||
    (borderDirection === 'right' && '0px 11px 11px 0px;')};
`;
