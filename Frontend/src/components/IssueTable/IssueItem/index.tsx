import user from '@public/image/user1.jpeg';

import { IssueItemProps } from '@/components/IssueTable/type';
import Label from '@/components/Label';
import UserImg from '@/components/UserImg';

import CheckBox from '../../common/CheckBox';
import * as S from './style';

export default function IssueItem({ issue }: IssueItemProps) {
  const { id, title, createdAt, mileStoneTitle, labels } = issue;
  return (
    <S.Container>
      <S.Wrapper1>
        <CheckBox />
        <S.Wrapper2>
          <S.Wrapper3>
            <S.Title>{title}</S.Title>
            {labels.map((label) => (
              <Label
                key={label.id}
                contents={label.title}
                size="small"
                labelStyle="light"
                background={label.color}
              />
            ))}
          </S.Wrapper3>
          <S.Wrapper3>
            <S.Content>#{id}</S.Content>
            <S.Content>{createdAt}</S.Content>
            <S.Content>{mileStoneTitle}</S.Content>
          </S.Wrapper3>
        </S.Wrapper2>
      </S.Wrapper1>
      <UserImg img={user} size="small" />
    </S.Container>
  );
}
