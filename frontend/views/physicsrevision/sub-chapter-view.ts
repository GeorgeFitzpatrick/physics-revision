import {customElement, html, LitElement} from 'lit-element';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout';
import '@vaadin/vaadin-select';
// @ts-ignore
import {applyTheme} from '../../generated/theme';

@customElement('sub-chapter-view')
export class SubChapterView extends LitElement {

    connectedCallback() {
        super.connectedCallback();
        applyTheme(this.renderRoot);
    }

    render() {
        return html`
            <vaadin-vertical-layout style="width: 100%; height: 100%;">
                <p><a href="/ ">Chapters</a> / <span id="chapter-title"></span> / <span id="sub-chapter-title"></span>
                </p>
                <h2 style="margin-top: 0; margin-bottom: 0;">Text Book</h2>

                <div class="bg-contrast-5"
                     style="border-style: solid; border-width: 0 0 0 4px; border-radius: 4px; padding: 16px 24px 16px 24px; margin: 16px 0 0 0; border-color: var(--lumo-success-text-color);">
                    <table>
                        <tbody>
                        <tr>
                            <td>
                                <p><strong>Kerboodle</strong></p>
                                <p>A Level Physics for OCR A Student Book (Year 1 & 2) by OUP Oxford.</p>
                                <a target="_blank" id="page-number"></a>
                            </td>
                            <td style="padding-left: 24px;">
                                <img src="image/text_book.jpg" style="width: auto; height: 100px" alt=""/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <h2 style="margin-bottom: 0;">Flashcards</h2>
                <ul style="width: 100%;" class="list-none m-0 p-0" id="flashcards-list"></ul>

                <h2 style="margin-bottom: 0;">Lessons</h2>
                <ul style="width: 100%;" class="list-none m-0 p-0" id="lessons-list"></ul>

                <h2 style="margin-bottom: 0;">Practice Questions</h2>
            </vaadin-vertical-layout>
        `;
    }

}

