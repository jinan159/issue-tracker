import styled from 'styled-components';

export const Container = styled.div<{
  width: string;
  height: string;
}>`
  position: relative;
  background-color: ${({ theme }) => theme.color.grey3};
  width: ${({ width }) => width};
  height: ${({ height }) => height};
`;

export const Content = styled.div<{
  width?: string | undefined;
  isStartFromRight?: boolean;
}>`
  display: none;
  position: absolute;
  width: ${({ width }) => width};
  background: transparent;
  box-shadow: 2px 2px 2px 2px ${({ theme }) => theme.color.grey3};
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
    border-top: 1px solid ${({ theme }) => theme.color.grey2};
  }
`;

export const DropDownTitle = styled.div`
  width: 100%;
  height: 100%;
`;
