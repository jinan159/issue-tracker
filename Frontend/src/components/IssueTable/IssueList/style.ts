import styled from 'styled-components';

const ZeroList = styled.div`
  width: 1280px;
  height: 200px;
  font-weight: 700;
  font-size: 28px;
  line-height: 32px;
  color: ${({ theme }) => theme.color.black};
  ${({ theme }) => theme.mixins.flexBox('row', 'center', 'center')};
`;

export { ZeroList };
