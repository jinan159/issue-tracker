import styled from 'styled-components';

const StyledButton = styled.button`
  cursor: pointer;
  border: none;
  background-color: transparent;
  &:disabled {
    color: grey;
    cursor: default;
  }
`;

export default StyledButton;
