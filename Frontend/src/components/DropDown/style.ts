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

export const DropdownLabel = styled.label``;

export const DropDown = styled.input<{
  constentsName: string;
  labelName: string;
}>`
  visibility: hidden;
  position: absolute;
  :checked
    + .${({ labelName }) => labelName}
    + .${({ constentsName }) => constentsName} {
    display: block;
    border-top: 1px solid ${({ theme }) => theme.colors.greyScale.line};
  }
`;

export const DropDownTitle = styled.div<{
  isMouseOvered: boolean;
}>`
  width: 100%;
  height: 100%;
  color: ${({ theme, isMouseOvered }) =>
    isMouseOvered ? theme.colors.greyScale.body : theme.colors.greyScale.label};
`;

export const Filter = styled.div`
  width: 100%;
  height: 100%;
  ${({ theme }) => theme.mixins.flexBox('row', 'center', 'space-around')};
`;

export const IconContainer = styled.div`
  ${({ theme }) => theme.mixins.flexBox('row', 'center', 'center')};
  padding-top: 10px;
`;
