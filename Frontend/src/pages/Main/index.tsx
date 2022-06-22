import Button from '../../components/common/Button';
import DropDown from '../../components/DropDown';
import Header from '../../components/Header';
import IssueTable from '../../components/IssueTable';
import * as S from './style';

const dropDownWidth = '128px';
const dropDownHeight = '40px';
const dropBoxWidth = '200px';
const dropDownTitle = ['필터', '상태수정'];
const itemsTitle = '이슈필터';

const items = [
  '열린 이슈',
  '내가 작성한 이슈',
  '나에게 작성한 이슈',
  '내가 댓글을 남긴 이슈',
  '닫힌 이슈',
];

export default function Main() {
  return (
    <>
      <Header />
      <S.Container>
        <S.SpaceBetweenContainer>
          <S.FlexContainer>
            <DropDown
              dropDownWidth={dropDownWidth}
              dropDownHeight={dropDownHeight}
              dropBoxWidth={dropBoxWidth}
              dropDownTitle={dropDownTitle[0]}
              itemsTitle={itemsTitle}
              items={items}
            />
            <S.SearchBar
              type="text"
              placeholder="is:issue is:open"
              height={dropDownHeight}
            />
          </S.FlexContainer>
          <div>
            <Button type="button" content="레이블" />
            <Button type="button" content="마일스톤" />
            <Button type="button" content="이슈작성" />
          </div>
          <DropDown
            dropDownWidth="100px"
            dropDownHeight="50px"
            dropBoxWidth={dropBoxWidth}
            dropDownTitle={dropDownTitle[0]}
            itemsTitle="상태변경"
            items={['선택한 이슈 열기', '선택한 이슈 닫기']}
            isStartFromRight
          />
        </S.SpaceBetweenContainer>
        <IssueTable />
      </S.Container>
    </>
  );
}
